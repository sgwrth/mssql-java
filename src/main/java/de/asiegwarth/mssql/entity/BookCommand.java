package de.asiegwarth.mssql.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookCommand {

    private String title;
    private String firstname;
    private String lastname;
    
}
