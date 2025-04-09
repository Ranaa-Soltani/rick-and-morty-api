package org.mathieu.cleanrmapi.data.location

import org.mathieu.cleanrmapi.domain.location.Location

class LocationRemoteDataSource {

    fun fetchLocationById(id: Int): Location {
        return Location(
            id = id,
            name = "Earth C-137",
            type = "Planet",
            dimension = "Dimension C-137",
            residents = emptyList()
        )
    }
}
