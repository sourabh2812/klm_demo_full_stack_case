package com.afkl.exercises.spring.paging;

import static org.springframework.hateoas.PagedResources.wrap;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.PagedResources.PageMetadata;
import org.springframework.hateoas.Resource;
import org.springframework.web.client.HttpServerErrorException;

import com.google.common.collect.Lists;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Pageable<T> {

	private final int page, size;

	public Pageable(int page, int size) {
		this.page = page;
		this.size = size;
	}

	public PagedResources<Resource<T>> partition(Collection<T> original) {
		if (original == null || original.isEmpty()) {
			throw new HttpServerErrorException(NOT_FOUND, "Unable to partition results, no results available.");
		}
		final List<List<T>> partitionedList = Lists
				.partition(original instanceof List ? (List<T>) original : new ArrayList<>(original), size);
		try {
			List<T> result = partitionedList.get(page == 0 ? page : page - 1);
			final PageMetadata metadata = new PageMetadata(size, page, original.size(), partitionedList.size());
			return wrap(result, metadata);
		} catch (IndexOutOfBoundsException e) {
			throw new IllegalArgumentException("Requested page is out of bounds.");
		}
	}

}
