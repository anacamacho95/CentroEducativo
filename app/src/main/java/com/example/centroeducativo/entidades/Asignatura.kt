package com.example.centroeducativo.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Asignatura")
class Asignatura (
    @ColumnInfo(name="nombre")
    var nombre: String): Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo (name="idAsignatura")
    var idAsignatura= 0

    override fun toString(): String {
        return "Asignatura(nombre='$nombre', idAsignatura=$idAsignatura)"
    }


}