package com.example.demo.generated.curddemo.curddemo.person.generated;

import com.example.demo.generated.curddemo.curddemo.person.Person;
import com.speedment.common.annotation.GeneratedCode;
import com.speedment.runtime.config.identifier.ColumnIdentifier;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.core.util.OptionalUtil;
import com.speedment.runtime.field.ComparableField;
import com.speedment.runtime.field.IntField;
import com.speedment.runtime.field.StringField;
import com.speedment.runtime.typemapper.TypeMapper;

import java.util.Optional;
import java.util.OptionalInt;

/**
 * The generated base for the {@link
 * com.example.demo.generated.curddemo.curddemo.person.Person}-interface
 * representing entities of the {@code person}-table in the database.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public interface GeneratedPerson {
    
    /**
     * This Field corresponds to the {@link Person} field that can be obtained
     * using the {@link Person#getId()} method.
     */
    IntField<Person, Integer> ID = IntField.create(
        Identifier.ID,
        Person::getId,
        Person::setId,
        TypeMapper.primitive(),
        true
    );
    /**
     * This Field corresponds to the {@link Person} field that can be obtained
     * using the {@link Person#getName()} method.
     */
    StringField<Person, String> NAME = StringField.create(
        Identifier.NAME,
        o -> OptionalUtil.unwrap(o.getName()),
        Person::setName,
        TypeMapper.identity(),
        false
    );
    /**
     * This Field corresponds to the {@link Person} field that can be obtained
     * using the {@link Person#getAge()} method.
     */
    ComparableField<Person, Integer, Integer> AGE = ComparableField.create(
        Identifier.AGE,
        o -> OptionalUtil.unwrap(o.getAge()),
        Person::setAge,
        TypeMapper.identity(),
        false
    );
    /**
     * This Field corresponds to the {@link Person} field that can be obtained
     * using the {@link Person#getAddress()} method.
     */
    StringField<Person, String> ADDRESS = StringField.create(
        Identifier.ADDRESS,
        o -> OptionalUtil.unwrap(o.getAddress()),
        Person::setAddress,
        TypeMapper.identity(),
        false
    );
    
    /**
     * Returns the id of this Person. The id field corresponds to the database
     * column curddemo.curddemo.person.id.
     * 
     * @return the id of this Person
     */
    int getId();
    
    /**
     * Returns the name of this Person. The name field corresponds to the
     * database column curddemo.curddemo.person.name.
     * 
     * @return the name of this Person
     */
    Optional<String> getName();
    
    /**
     * Returns the age of this Person. The age field corresponds to the database
     * column curddemo.curddemo.person.age.
     * 
     * @return the age of this Person
     */
    OptionalInt getAge();
    
    /**
     * Returns the address of this Person. The address field corresponds to the
     * database column curddemo.curddemo.person.address.
     * 
     * @return the address of this Person
     */
    Optional<String> getAddress();
    
    /**
     * Sets the id of this Person. The id field corresponds to the database
     * column curddemo.curddemo.person.id.
     * 
     * @param id to set of this Person
     * @return   this Person instance
     */
    Person setId(int id);
    
    /**
     * Sets the name of this Person. The name field corresponds to the database
     * column curddemo.curddemo.person.name.
     * 
     * @param name to set of this Person
     * @return     this Person instance
     */
    Person setName(String name);
    
    /**
     * Sets the age of this Person. The age field corresponds to the database
     * column curddemo.curddemo.person.age.
     * 
     * @param age to set of this Person
     * @return    this Person instance
     */
    Person setAge(Integer age);
    
    /**
     * Sets the address of this Person. The address field corresponds to the
     * database column curddemo.curddemo.person.address.
     * 
     * @param address to set of this Person
     * @return        this Person instance
     */
    Person setAddress(String address);
    
    enum Identifier implements ColumnIdentifier<Person> {
        
        ID      ("id"),
        NAME    ("name"),
        AGE     ("age"),
        ADDRESS ("address");
        
        private final String columnId;
        private final TableIdentifier<Person> tableIdentifier;
        
        Identifier(String columnId) {
            this.columnId        = columnId;
            this.tableIdentifier = TableIdentifier.of(    getDbmsId(), 
                getSchemaId(), 
                getTableId());
        }
        
        @Override
        public String getDbmsId() {
            return "curddemo";
        }
        
        @Override
        public String getSchemaId() {
            return "curddemo";
        }
        
        @Override
        public String getTableId() {
            return "person";
        }
        
        @Override
        public String getColumnId() {
            return this.columnId;
        }
        
        @Override
        public TableIdentifier<Person> asTableIdentifier() {
            return this.tableIdentifier;
        }
    }
}