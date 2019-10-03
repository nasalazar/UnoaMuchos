/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entity.Diplomado;
import Entity.Universidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author NATHALY
 */
@Local
public interface DiplomadoFacadeLocal {

    void create(Diplomado diplomado);

    void edit(Diplomado diplomado);

    void remove(Diplomado diplomado);

    Diplomado find(Object id);

    List<Diplomado> findAll();

    List<Diplomado> findRange(int[] range);

    int count();
    
    List<Diplomado> validaUniversidadAsignada(Universidad uni, String nombreD);
    
}
