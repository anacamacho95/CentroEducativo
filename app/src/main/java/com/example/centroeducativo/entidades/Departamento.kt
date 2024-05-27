package com.example.centroeducativo.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Departamento")
class Departamento (
    @ColumnInfo(name="nombre")
    var nombre : String): Serializable {
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name="idDepartamento")
        var idDepartamento = 0
    override fun toString(): String {
        return "Departamento(nombre='$nombre', idDepartamento=$idDepartamento)"
    }


}