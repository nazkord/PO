package pl.edu.agh.dronka.shop.model.filters;

import pl.edu.agh.dronka.shop.model.Item;

public class ItemFilter {

	private FilterSpec filter = new FilterSpec();

	public FilterSpec getFilter() {
		return filter;
	}

	public boolean appliesTo(Item item) {
//		if (itemSpec.getName() != null
//				&& !itemSpec.getName().equals(item.getName())) {
//			return false;
//		}

		if (filter.getCategory() != null
				&& !filter.getCategory().equals(item.getCategory())) {
			return false;
		}

		// applies filter only if the flag (secondHand) is true)
		if (filter.isSecondHand() && !item.isSecondHand()) {
			return false;
		}

		// applies filter only if the flag (polish) is true)
		if (filter.isPolish() && !item.isPolish()) {
			return false;
		}

		return item.isAdditionalFieldsAppliedTo(filter);
	}
}