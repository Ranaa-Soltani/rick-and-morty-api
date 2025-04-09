package org.mathieu.cleanrmapi.data.location

import org.mathieu.cleanrmapi.domain.location.Location

class InMemoryLocationCacheDataSource : LocationCacheDataSource {

    private val cache = mutableMapOf<Int, Location>()

    override fun getLocationById(id: Int): Location? = cache[id]

    override fun saveLocation(location: Location) {
        cache[location.id] = location
    }
}
