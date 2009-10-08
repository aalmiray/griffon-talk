import groovy.beans.Bindable
import ca.odell.glazedlists.EventList
import ca.odell.glazedlists.BasicEventList
import ca.odell.glazedlists.SortedList

class InitModel {
   EventList shortcuts = new SortedList(new BasicEventList(),
     {a, b -> a.title <=> b.title} as Comparator)
}