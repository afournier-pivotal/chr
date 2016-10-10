/**
 * 
 */
package com.lukeshannon.springconference.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.lukeshannon.springconference.model.Rating;

/**
 * @author lshannon
 *
 */
public interface RatingRepo extends PagingAndSortingRepository<Rating,Long> {

}
