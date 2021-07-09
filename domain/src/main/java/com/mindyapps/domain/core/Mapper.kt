package com.mindyapps.domain.core

interface Mapper<E, D> {

    fun mapFrom(from: E): D

    fun mapTo(from: D): E

}
