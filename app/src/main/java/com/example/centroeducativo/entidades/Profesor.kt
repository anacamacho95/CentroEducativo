package com.example.centroeducativo.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Profesor",
    foreignKeys = [
        ForeignKey(
            entity = Departamento::class,
            parentColumns = ["idDepartamento"],
            childColumns = ["departamento"]
        )
    ]
)
class Profesor (
    @ColumnInfo(name = "nombre")
    var nombre: String,
    @ColumnInfo(name = "apellido")
    var apellido: String,
    @ColumnInfo(name = "departamento")
    var departamento: Int
): Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="idProfesor")
    var idProfesor=0
    override fun toString(): String {
        return "Profesor(nombre='$nombre', apellido='$apellido', departamento=$departamento, idProfesor=$idProfesor)"
    }


}