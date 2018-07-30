package hw6.config;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import hw6.table.TableLine;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;

import java.util.Locale;
import java.util.Map;

/**
 * Created by Ekaterina on 29.07.2018.
 */
public class DataTableConfigurer implements TypeRegistryConfigurer {

    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry registry) {
        registry.defineDataTableType(new DataTableType(TableLine.class, new TableEntryTransformer<TableLine>() {
            @Override
            public TableLine transform(Map<String, String> entry) {
                return new TableLine(entry.get("Number"), entry.get("Type"),
                        entry.get("Desciption"), entry.get("User"));
            }
        }));
        registry.defineDataTableType(new DataTableType(String.class, new TableEntryTransformer<String>() {
            @Override
            public String transform(Map<String, String> map) throws Throwable {
                return map.get("Dropdown Values");
            }
        }));

    }

}
