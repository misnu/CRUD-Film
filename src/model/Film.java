/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nunu
 */
public class Film {
    
     private int id;
    private String judul;
    private String sinopsis;
    private int tahun;
    
    public int getId()
    {
        return this.id;
    }
    public String getJudul()
    {
        return this.judul;
    }
    public String getSinopsis()
    {
        return this.sinopsis;
    }
    public int getTahun()
    {
        return this.tahun;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    public void setJudul(String judul)
    {
        this.judul = judul;
    }
    public void setSinopsis(String sinopsis)
    {
        this.sinopsis = sinopsis;
    }
    public void setTahun(int tahun)
    {
        this.tahun = tahun;
    }
}
