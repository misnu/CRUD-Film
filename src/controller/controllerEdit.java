/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.daoFilm;
import dao.interfaceFilm;
import javax.swing.JOptionPane;
import model.Film;
import view.viewEdit;
import view.viewUtama;


public class controllerEdit {
    
    viewEdit frame;
interfaceFilm infcFilm;

public controllerEdit(viewEdit frame) {
 this.frame = frame;
 infcFilm = new daoFilm();
}
public void tampilkanData(Film film1){
 frame.setTxtJudul(film1.getJudul());
 frame.setTxtSinopsis(film1.getSinopsis());
 frame.setTxtTahun(Integer.toString(film1.getTahun()));
}

public void simpanEdit(int id_film){
 Film film_edit = new Film();
 film_edit.setJudul(frame.getTxtJudul().getText());
 film_edit.setSinopsis(frame.getTxtSinopsis().getText());
 film_edit.setTahun(Integer.parseInt(frame.getTxtTahun().getText()));
 film_edit.setId(id_film);
infcFilm.update(film_edit);
 JOptionPane.showMessageDialog(frame, "Berhasil mengedit data");
 
 kembali();
 }

public void kembali(){
 frame.dispose();
 new viewUtama().setVisible(true);
}
}
