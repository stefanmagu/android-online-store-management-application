package com.example.tema2.DAOs;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.tema2.models.Utilizator;

import java.util.List;

@Dao
public interface UtilizatorDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertUtilizator(Utilizator utilizator);

    @Query("SELECT * FROM Utilizatori")
    List<Utilizator> getUtilizatori();

    @Query("SELECT COUNT(*) FROM Utilizatori WHERE nume = :nume AND prenume = :prenume AND parola =:parola")
    int userExists(String nume,String prenume, String parola);

    @Query("SELECT idUtilizator FROM Utilizatori WHERE nume = :nume AND prenume = :prenume AND parola =:parola")
    int getIdUtilizator(String nume, String prenume, String parola);

}
