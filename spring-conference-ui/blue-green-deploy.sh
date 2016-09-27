echo "Clean and Package the Application"
mvn clean package
echo ""	

DOMAIN=cfapps.io
ORIGINAL_APP=toronto-spring-conference
NEW_APP=toronto-spring-conference-new
OLD_APP=toronto-spring-conference-old

# push the application with a manifest that binds all required services
echo "**Pushing the 'New' Service with a route different than the currently running one"
echo "cf push -n $NEW_APP"
cf push $NEW_APP -n $NEW_APP
echo ""

# Run Tests on the newly deployed app check that it is okay
echo "**Testing the new service on its own route"
echo ""
RESPONSE=`curl -sI http://NEW_APP.$DOMAIN`
echo "$RESPONSE"
if [[ $RESPONSE != *"HTTP/1.1 200 OK"* ]]
then
  echo "Service Did Not Start Up - Stopping Upgrade...";
  cf delete $NEW_APP -f;
  echo "New Service Deleted"
  echo "Upgrade Stopping"
  exit 1;
fi
echo ""

# scale up the new app instance
echo "**Scaling Up The New Application To Handle Load Of Currently Running Application"
echo "cf scale $NEW_APP -i 3"
cf scale $NEW_APP -i 3
echo ""

# start directing traffic to the new app instance
echo "**Move Traffic (PCF Route) from the Currently Running App to the new one"
echo "cf map-route $NEW_APP $DOMAIN -n $ORIGINAL_APP"
cf map-route $NEW_APP $DOMAIN -n $ORIGINAL_APP
echo ""

# stop taking traffic on the current prod instance
echo "**Unmap the Current Application So No More Traffic Reaches It (going to the new one now)"
echo "cf unmap-route $ORIGINAL_APP $DOMAIN -n $ORIGINAL_APP"
cf unmap-route $ORIGINAL_APP $DOMAIN -n $ORIGINAL_APP
echo ""

# scale down the proi app instances
echo "**Scale Down The Current Application instances To Save On Resources"
echo "cf scale $ORIGINAL_APP -i 1"
cf scale $ORIGINAL_APP -i 1
echo ""

# decommission the old app
echo "**Stop the Current application"
echo "cf stop $ORIGINAL_APP"
cf stop $ORIGINAL_APP
echo ""

# delete any version of the old app that might be lying around still
echo "**Delete any old back up versions of the application (from a previous blue green)"
echo "cf delete $OLD_APP -f"
cf delete $OLD_APP -f

echo "**Rename the current service to be 'old' as our new app has taken its place"
echo "cf rename $ORIGINAL_APP $OLD_APP"
cf rename $ORIGINAL_APP $OLD_APP
echo ""

# clean up the temp route
echo "**Remove the temp route"
echo "cf unmap-route $NEW_APP $DOMAIN -n $NEW_APP"
cf unmap-route $NEW_APP $DOMAIN -n $NEW_APP
echo ""

# rename the app
echo "**Rename the app so naming makes sense in the Console"
echo "cf rename $NEW_APP $ORIGINAL_APP"
cf rename $NEW_APP $ORIGINAL_APP