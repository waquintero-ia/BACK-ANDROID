package com.example.crudretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.crudretrofit.model.Empleado;
import com.example.crudretrofit.sinterface.CrudEmpleadoInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Empleado postEmpleado;
    CrudEmpleadoInterface cruempleado;
    List<Empleado> listEmpleado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getAll();
        postAll();
        deleteAll();
    }

    private void getAll(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.12:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        cruempleado = retrofit.create(CrudEmpleadoInterface.class);
        Call<List<Empleado>> call = cruempleado.getAll();

        call.enqueue(new Callback<List<Empleado>>() {
            @Override
            public void onResponse(Call<List<Empleado>> call, Response<List<Empleado>> response) {
                if (!response.isSuccessful()){
                    //System.out.println(response.message());
                    Log.e ("Response err:,", response.message());
                    return;
                }
                listEmpleado = response.body();
                //listEmpleado.forEach (p-> System.out.println(p.toString()));
                listEmpleado.forEach(p->Log.i("Empleados: ", p.toString()));
            }

            @Override
            public void onFailure(Call<List<Empleado>> call, Throwable t) {
                //System.out.println(t.getMessage());
                Log.e("Throw error:",t.getMessage());
            }
        });

    }

    private void postAll(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.12:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        cruempleado = retrofit.create(CrudEmpleadoInterface.class);
        Call<List<Empleado>> call = cruempleado.getAll();

        call.enqueue(new Callback<List<Empleado>>() {
            @Override
            public void onResponse(Call<List<Empleado>> call, Response<List<Empleado>> response) {
                if (!response.isSuccessful()){
                    //System.out.println(response.message());
                    Log.e ("Response err:,", response.message());
                    return;
                }

                long id = 0;
                String nombre = "0";
                String email = "0";
                String password = "0";
                postEmpleado.setId(id);
                postEmpleado.setNombre(nombre);
                postEmpleado.setEmail(email);
                postEmpleado.setPassword(password);

            }

            @Override
            public void onFailure(Call<List<Empleado>> call, Throwable t) {
                //System.out.println(t.getMessage());
                Log.e("Throw error:",t.getMessage());
            }
        });


    }

    private void deleteAll(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.12:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        cruempleado = retrofit.create(CrudEmpleadoInterface.class);
        Call<List<Empleado>> call = cruempleado.getAll();

        call.enqueue(new Callback<List<Empleado>>() {
            @Override
            public void onResponse(Call<List<Empleado>> call, Response<List<Empleado>> response) {
                if (!response.isSuccessful()){
                    //System.out.println(response.message());
                    Log.e ("Response err:,", response.message());
                    return;
                }

            }

            @Override
            public void onFailure(Call<List<Empleado>> call, Throwable t) {
                //System.out.println(t.getMessage());
                Log.e("Throw error:",t.getMessage());
            }
        });
    }

}