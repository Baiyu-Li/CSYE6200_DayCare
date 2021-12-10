/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Factory;

import Model.Organization.AbstractOrganization;

/**
 *
 * @author fuyanping
 */
public abstract class AbstractFactory {
    public abstract AbstractOrganization getObject(String s);
}
