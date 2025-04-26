package com.wappClone.models

import jakarta.persistence.*

@Entity
@Table(name = "usuario")
data class Usuario(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "nombre", nullable = false)
    val nombre: String,

    @Column(apellido = "apellido", nullable = false)
    val apellido: String,

    @Column(telefono = "telefono", nullable = false)
    val telefono: String,

    // este estado es el del perfil del usuario, por ejemplo cuando tocas en un perfil que salga 'Disponible'
    @Column(estado = "estado", nullable = true)
    val estado: String
)
