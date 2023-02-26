package dev.lissandrocunha.forum.mapper

interface Mapper<S, D> {

    fun map(source: S): D
}
