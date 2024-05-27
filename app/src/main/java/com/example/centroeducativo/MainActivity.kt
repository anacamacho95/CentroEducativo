package com.example.centroeducativo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.centroeducativo.conexiones.BDRoom
import com.example.centroeducativo.entidades.AsigProf
import com.example.centroeducativo.entidades.Asignatura
import com.example.centroeducativo.entidades.Departamento
import com.example.centroeducativo.entidades.Profesor
import com.example.centroeducativo.interfaces.InterfaceDaoAsigProf
import com.example.centroeducativo.interfaces.InterfaceDaoAsignaturas
import com.example.centroeducativo.interfaces.InterfaceDaoDepartamento
import com.example.centroeducativo.interfaces.InterfaceDaoProfesor

class MainActivity : AppCompatActivity() {
    lateinit var conexion: BDRoom
    lateinit var daoAsignatura: InterfaceDaoAsignaturas
    lateinit var daoDepartamento: InterfaceDaoDepartamento
    lateinit var daoProfesor: InterfaceDaoProfesor
    lateinit var daoAsigProf: InterfaceDaoAsigProf

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        conexion=BDRoom.getBaseDatos(this)
        daoAsignatura=conexion.daoAsignatura()
        daoDepartamento=conexion.daoDepartamento()
        daoProfesor=conexion.daoProfesor()
        daoAsigProf=conexion.daoAsigProf()


        pruebaAsignatura()
        Log.d("pruebas", "---------------------------")
        pruebaDepartamento()
        Log.d("pruebas", "---------------------------")
        pruebaProfesor()
        Log.d("pruebas", "---------------------------")
        pruebaAsigProf()
        borraTablas()
    }

    private fun borraTablas() {
        daoAsignatura.borraTablaAsignatura()
        daoAsigProf.borraTablaAsigProf()
        daoDepartamento.borraTablaDep()
        daoProfesor.borraTablaProf()

    }

    private fun pruebaAsignatura() {
        Log.d("pruebas", "Añado y veo Asignaturas")
        daoAsignatura.addAsignatura(Asignatura("Acceso a Datos"))
        daoAsignatura.addAsignatura(Asignatura("Programacion"))
        daoAsignatura.addAsignatura(Asignatura("Sistemas"))

        daoAsignatura.getAsignaturas().forEach{
            Log.d("pruebas", it.toString())
        }

        Log.d("pruebas", "Veo una Asignatura")
        Log.d("pruebas", daoAsignatura.getAsignatura("Programacion").toString())

        Log.d("pruebas", "Actualizo una Asignatura")
        var actualizoAsig = daoAsignatura.getAsignatura("Sistemas")
        actualizoAsig.nombre="Lenguaje de Marcas"
        daoAsignatura.updateAsignatura(actualizoAsig)
        Log.d("pruebas", daoAsignatura.getAsignatura("Lenguaje de Marcas").toString())

        Log.d("pruebas", "Borro una Asignatura")
        var borroAsig = daoAsignatura.getAsignatura("Lenguaje de Marcas")
        daoAsignatura.deleteAsignatura(borroAsig)
        daoAsignatura.getAsignaturas().forEach{
            Log.d("pruebas", it.toString())
        }
    }
    private fun pruebaProfesor() {
        Log.d("pruebas", "Añado y veo Profesores")
        daoProfesor.addProfesor(Profesor("Enrique", "Matas", daoDepartamento.getDepartamento("Acceso a Datos").idDepartamento))
        daoProfesor.addProfesor(Profesor("Dioni", "Penalosa", daoDepartamento.getDepartamento("Programacion").idDepartamento))
        daoProfesor.addProfesor(Profesor("Bernat", "X", daoDepartamento.getDepartamento("IONIC").idDepartamento))

        daoProfesor.getProfesores().forEach{
            Log.d("pruebas", it.toString())
        }

        Log.d("pruebas", "Veo una Profesor")
        Log.d("pruebas", daoProfesor.getProfesor("Dioni").toString())

        Log.d("pruebas", "Actualizo un Profesor")
        var actualizoProf = daoProfesor.getProfesor("Acceso a Datos")
        actualizoProf.nombre="Maria Jose"
        daoProfesor.updateProfesor(actualizoProf)
        Log.d("pruebas", daoProfesor.getProfesor("Maria Jose").toString())

        Log.d("pruebas", "Borro una Asignatura")
        var borroProf = daoProfesor.getProfesor("Bernat")
        daoProfesor.deleteProfesor(borroProf)
        daoProfesor.getProfesores().forEach{
            Log.d("pruebas", it.toString())
        }
    }
    private fun pruebaDepartamento() {
        Log.d("pruebas", "Añado y veo Departamentos")
        daoDepartamento.addDepartamento(Departamento("Acceso a Datos"))
        daoDepartamento.addDepartamento(Departamento("Base de datos"))
        daoDepartamento.addDepartamento(Departamento("Sistemas"))

        daoDepartamento.getDepartamentos().forEach{
            Log.d("pruebas", it.toString())
        }

        Log.d("pruebas", "Veo una Departamento")
        Log.d("pruebas", daoDepartamento.getDepartamento("Sistemas").toString())

        Log.d("pruebas", "Actualizo un Departamento")
        var actualizodep = daoDepartamento.getDepartamento("Sistemas")
        actualizodep.nombre="FOL"
        daoDepartamento.updateDepartamento(actualizodep)
        Log.d("pruebas", daoDepartamento.getDepartamento("FOL").toString())

        Log.d("pruebas", "Borro un Departamento")
        var borroDep = daoDepartamento.getDepartamento("FOL")
        daoDepartamento.deleteDepartamento(borroDep)
        daoDepartamento.getDepartamentos().forEach{
            Log.d("pruebas", it.toString())
        }
    }

    private fun pruebaAsigProf() {
        Log.d("pruebas", "Añado y veo AsigProf")
        daoAsigProf.addAsigProf(AsigProf(daoAsignatura.getAsignatura("Acceso a Datos").idAsignatura,daoProfesor.getProfesor("Enrique").idProfesor))
        daoAsigProf.addAsigProf(AsigProf(daoAsignatura.getAsignatura("Programacion").idAsignatura,daoProfesor.getProfesor("Dioni").idProfesor))

        daoAsigProf.getAsigProfs().forEach{
            Log.d("pruebas", it.toString())
        }

        Log.d("pruebas", "Borro un AsigProf")
        daoAsigProf.deleteAsigProf(AsigProf(daoAsignatura.getAsignatura("Programacion").idAsignatura,daoProfesor.getProfesor("Dioni").idProfesor))
        daoAsigProf.getAsigProfs().forEach{
            Log.d("pruebas", it.toString())
        }
    }
}