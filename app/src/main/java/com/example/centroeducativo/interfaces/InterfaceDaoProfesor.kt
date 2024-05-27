package com.example.centroeducativo.interfaces

import androidx.room.*
import com.example.centroeducativo.entidades.Profesor
@Dao
interface InterfaceDaoProfesor {
    //CRUD
    @Insert
    fun addProfesor (prof: Profesor)
    @Query("SELECT * FROM Profesor")
    fun getProfesores(): MutableList<Profesor>
    @Query("SELECT * FROM Profesor WHERE nombre = :nombreProf")
    fun getProfesor(nombreProf: String): Profesor
    @Update
    fun updateProfesor(prof: Profesor)
    @Delete
    fun deleteProfesor (prof: Profesor)
    @Query("DELETE FROM Profesor")
    fun borraTablaProf()
}