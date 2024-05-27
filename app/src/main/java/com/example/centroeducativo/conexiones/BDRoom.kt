package com.example.centroeducativo.conexiones

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.centroeducativo.entidades.AsigProf
import com.example.centroeducativo.entidades.Asignatura
import com.example.centroeducativo.entidades.Departamento
import com.example.centroeducativo.entidades.Profesor
import com.example.centroeducativo.interfaces.InterfaceDaoAsigProf
import com.example.centroeducativo.interfaces.InterfaceDaoAsignaturas
import com.example.centroeducativo.interfaces.InterfaceDaoDepartamento
import com.example.centroeducativo.interfaces.InterfaceDaoProfesor

@Database(entities = [Asignatura::class, Departamento::class, Profesor::class, AsigProf::class], version = 1)
abstract class BDRoom: RoomDatabase(){

    abstract fun daoAsignatura(): InterfaceDaoAsignaturas
    abstract fun daoDepartamento(): InterfaceDaoDepartamento
    abstract fun daoProfesor(): InterfaceDaoProfesor
    abstract fun daoAsigProf(): InterfaceDaoAsigProf

    companion object {
        var INSTANCE: BDRoom?=null
        fun getBaseDatos(context: Context): BDRoom {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    BDRoom::class.java,
                    "CenEduBaseDatos"
                ).allowMainThreadQueries().build()
                //Con migracion hay que incrementar la version y añadirle que migracion
                /*INSTANCE = Room.databaseBuilder(context.getApplicationContext(),BaseDatos.class,
                    "DietaBD").addMigrations(MIGRATION1_2).allowMainThreadQueries().build();*/
            }
            return INSTANCE as BDRoom
        }
    }
}