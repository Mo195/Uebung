package de.krischkes.moritz.uebung.ActiveAndroid;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Moritzkrischke on 30/12/15.
 */
public class DatabaseTables {

    @Table(name="Categories")
    public class Category extends Model {
        @Column(name = "Name")
        public String name;
    }

    @Table(name="Items")
    public class Item extends Model {
        @Column(name="Name")
        public String name;

        @Column(name="Category")
        public Category category;
    }
}
