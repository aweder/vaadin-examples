package nl.example.vaadin.table;

import java.util.Date;
import java.util.Random;

import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.Table;

/**
 * 
 * This plain table extends the {@link Table} and uses an indexed container with three columns of different types as a data source.
 *
 */
public class BasicIndexedContainerTable extends Table {
	private static final long serialVersionUID = -6622477232787800750L;
	
	private static String NAME_COLUMN_ID = "name";
	private static String AGE_COLUMN_ID = "age";
	private static String DATE_COLUMN_ID = "date";

	public BasicIndexedContainerTable() {
		setContainerDataSource(createExampleData());
	}
	
	/*
	 * Creates a {@link IndexedContainer} with three columns of type String, Integer and Date as example data.
	 */
	private static IndexedContainer createExampleData() {
		String[] fieldNameData = { "Peter", "Alice", "Joshua", "Mike", "Olivia",
				"Nina", "Alex", "Rita", "Dan", "Umberto", "Henrik", "Rene",
                "Lisa", "Marge" };
		
		IndexedContainer indexedContainer = new IndexedContainer();
		
		
		indexedContainer.addContainerProperty(NAME_COLUMN_ID, String.class, "");
		indexedContainer.addContainerProperty(AGE_COLUMN_ID, Integer.class, "");
		indexedContainer.addContainerProperty(DATE_COLUMN_ID, Date.class, null);
		
		for (int i = 0; i < fieldNameData.length; i++) {
			Object itemId = indexedContainer.addItem();
			indexedContainer.getContainerProperty(itemId, NAME_COLUMN_ID).setValue(fieldNameData[i]);
			indexedContainer.getContainerProperty(itemId, AGE_COLUMN_ID).setValue(new Random().nextInt(100));
			indexedContainer.getContainerProperty(itemId, DATE_COLUMN_ID).setValue(new Date());			
		}
		
		return indexedContainer;
	}
}
