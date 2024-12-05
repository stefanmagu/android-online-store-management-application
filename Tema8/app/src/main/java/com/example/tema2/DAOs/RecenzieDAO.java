package com.example.tema2.DAOs;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.tema2.models.Recenzie;
import com.example.tema2.models.Utilizator;

import java.util.List;
@Dao
public interface RecenzieDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertRecenzie(Recenzie recenzie);

    @Update
    void updateRecenzie(Recenzie recenzie);

    @Query("SELECT * FROM Recenzii")
    List<Recenzie> getAllRecenzii();

    @Query("SELECT * FROM Recenzii WHERE idUtilizator = :idUtilizator")
    List<Recenzie> getRecenziiUtilizatorLogged(int idUtilizator);

    @Query("DELETE FROM Recenzii WHERE idRecenzie = :idRecenzie")
    void deleteRecenzie(int idRecenzie);

}
