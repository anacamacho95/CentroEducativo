package com.example.centroeducativo.interfaces

import androidx.room.*
import com.example.centroeducativo.entidades.Departamento
@Dao
interface InterfaceDaoDepartamento {
    //CRUD
    @Insert
    fun addDepartamento (dep: Departamento)
    @Query("SELECT * FROM Departamento")
    fun getDepartamentos(): MutableList<Departamento>
    @Query("SELECT * FROM Departamento WHERE nombre = :nombreDep")
    fun getDepartamento(nombreDep: String): Departamento
    @Update
    fun updateDepartamento(dep: Departamento)
    @Delete
    fun deleteDepartamento (dep: Departamento)

    @Query("DELETE FROM Departamento")
    fun borraTablaDep()
}