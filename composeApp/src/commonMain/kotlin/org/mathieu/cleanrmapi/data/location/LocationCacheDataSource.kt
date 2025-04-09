package org.mathieu.cleanrmapi.data.location

import org.mathieu.cleanrmapi.domain.location.Location

interface LocationCacheDataSource {
    fun getLocationById(id: Int): Location?
    fun saveLocation(location: Location)
}
