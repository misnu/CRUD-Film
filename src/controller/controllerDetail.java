/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.daoFilm;
import dao.interfaceFilm;
import model.Film;
import view.viewDetail;
import view.viewEdit;
import view.viewUtama;

public class controllerDetail {
    
    
    viewDetail frame;
interfaceFilm infcFilm;

public controllerDetail(viewDetail frame) {
 this.frame = frame;
 infcFilm = new daoFilm();
}

public void tampilkanData(Film film1){
 frame.setOutJudul(film1.getJudul());
 frame.setOutSinopsis(film1.getSinopsis());
 frame.setOutTahun(film1.getTahun());
}

public void hapusData(int id_film){
 infcFilm.delete(id_film);
 
 kembali();
}
public void halaman_edit(Film film1){
 frame.dispose();
 new viewEdit(film1).setVisible(true);
}

public void kembali(){
 frame.dispose();
 new viewUtama().setVisible(true);
}

}
