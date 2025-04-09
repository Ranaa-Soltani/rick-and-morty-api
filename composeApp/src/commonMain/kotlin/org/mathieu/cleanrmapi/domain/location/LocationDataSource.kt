package org.mathieu.cleanrmapi.domain.location

interface LocationDataSource {
    fun getLocationById(id: Int): Location
}
