package com.ting.wong.code.design.pattern.observer; /***********************************************************************
 * Module:  Subject.java
 * Author:  11091188
 * Purpose: Defines the Class Subject
 ***********************************************************************/

import java.util.*;
import java.util.Observer;

/** 1.8
 * DAG图类
 * Ting Wong
 * 1.0
 * java.lang.String
 * @pdOid 091ff5d0-18a2-4e0c-9586-d23103221a9b */
public abstract class Subject {
   /** @param o
    * @pdOid 41c183cb-b5d0-4dcf-83bc-abeb9498bf03 */
   public int attach(java.util.Observer o) {
      // TODO: implement
      return 0;
   }
   
   /** @param o
    * @pdOid 7459eee8-f1f7-4229-b8e0-659cc2ab647d */
   public int detach(Observer o) {
      // TODO: implement
      return 0;
   }
   
   /** @param args
    * @pdOid 00f805b4-2569-4552-a7bd-05657deb416e */
   public boolean notify(String args) {
      // TODO: implement
      return false;
   }

}