package com.mycompany.curroop;
public interface Employee <T> {
        public void create();
        public void read(T o);
        public void update(T o);
        public void delete(T o);
        public void show();
}
