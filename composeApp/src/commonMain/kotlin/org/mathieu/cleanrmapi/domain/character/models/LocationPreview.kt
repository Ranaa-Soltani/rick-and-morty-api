package org.mathieu.cleanrmapi.domain.character.models

/**
 * A simplified version of a Location, used to display basic info about a character's location.
 *
 * This model is useful when we don't need all the details (like dimension or residents),
 * just the essentials: name, ID, and where the character is originally from.
 *
 * @property id Unique ID of the location.
 * @property name Name of the location.
 * @property origin Where the character comes from originally (name or ID).
 */
data class LocationPreview(
    val id: String,
    val name: String,
)