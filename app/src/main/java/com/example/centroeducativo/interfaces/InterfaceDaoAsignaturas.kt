package com.example.centroeducativo.interfaces

import androidx.room.*
import com.example.centroeducativo.entidades.Asignatura
@Dao
interface InterfaceDaoAsignaturas {
    //CRUD
    @Insert
    fun addAsignatura (asig: Asignatura)
    @Query("SELECT * FROM Asignatura")
    fun getAsignaturas(): MutableList<Asignatura>
    @Query("SELECT * FROM Asignatura WHERE nombre = :nombreAsig")
    fun getAsignatura(nombreAsig: String): Asignatura
    @Update
    fun updateAsignatura(asig: Asignatura)
    @Delete
    fun deleteAsignatura (asig: Asignatura)

    @Query("DELETE FROM Asignatura")
    fun borraTablaAsignatura()
}