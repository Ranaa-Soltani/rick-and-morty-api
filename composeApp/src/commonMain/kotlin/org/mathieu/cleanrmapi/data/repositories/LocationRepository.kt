package org.mathieu.cleanrmapi.data.repositories

import org.mathieu.cleanrmapi.data.location.LocationCacheDataSource
import org.mathieu.cleanrmapi.data.location.LocationRemoteDataSource
import org.mathieu.cleanrmapi.domain.location.Location
import org.mathieu.cleanrmapi.domain.location.LocationDataSource
/**
 * Repository implementation for managing Location data using a cache-first strategy.
 */
class LocationRepository(
    private val cache: LocationCacheDataSource,
    private val remote: LocationRemoteDataSource
) : LocationDataSource {

    override fun getLocationById(id: Int): Location {
        val cached = cache.getLocationById(id)
        if (cached != null) {
            return cached
        }

        val fetched = remote.fetchLocationById(id)
        cache.saveLocation(fetched)
        return fetched
    }
}
