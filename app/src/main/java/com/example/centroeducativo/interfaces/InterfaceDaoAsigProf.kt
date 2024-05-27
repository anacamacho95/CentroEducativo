package com.example.centroeducativo.interfaces

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.centroeducativo.entidades.AsigProf
@Dao
interface InterfaceDaoAsigProf {
    @Insert
    fun addAsigProf(asigProf: AsigProf)

    @Query("SELECT a.nombre || p.nombre FROM AsigProf ap JOIN Asignatura a ON ap.asignaturaId = a.idAsignatura JOIN Profesor p ON ap.profesorId = p.idProfesor")
    fun getAsigProfs(): MutableList<String>

    @Delete
    fun deleteAsigProf(asigProf: AsigProf)

    @Query("DELETE FROM AsigProf")
    fun borraTablaAsigProf()
}