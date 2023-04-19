package com.example.crudretrofit.sinterface;

import com.example.crudretrofit.model.Empleado;

import java.util.List;

import retrofit2.Call;

import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface CrudEmpleadoInterface {

    @GET("/consultarAll")
    Call<List<Empleado>> getAll();

    @POST("/guardar")
    Call<List<Empleado>> postAll();

    @DELETE("/user/{id}")
    Call<List<Empleado>> deleteAll();


}
