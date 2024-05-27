package com.example.centroeducativo.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "AsigProf",
    primaryKeys = ["asignaturaId","profesorId" ],
    foreignKeys = [
        ForeignKey(
            entity = Asignatura::class,
            parentColumns = ["idAsignatura"],
            childColumns = ["asignaturaId"]
        ),
        ForeignKey(
            entity = Profesor::class,
            parentColumns = ["idProfesor"],
            childColumns = ["asignaturaId"]
        )
    ]
)
class AsigProf (
    @ColumnInfo(name="asignaturaId")
    var asignaturaId: Int = 0,
    @ColumnInfo(name="profesorId")
    var profesorId: Int = 0,
    ){
    override fun toString(): String {
        return "AsigProf(asignaturaId=$asignaturaId, profesorId=$profesorId)"
    }
}