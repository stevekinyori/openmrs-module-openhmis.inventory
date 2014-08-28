package org.openmrs.module.webservices.rest.resource;

import org.openmrs.module.openhmis.commons.api.entity.IObjectDataService;
import org.openmrs.module.openhmis.inventory.api.model.ItemStockDetail;
import org.openmrs.module.openhmis.inventory.api.model.ItemStockDetailBase;
import org.openmrs.module.openhmis.inventory.api.model.StockOperationItem;
import org.openmrs.module.openhmis.inventory.model.ItemStockEntry;
import org.openmrs.module.webservices.rest.web.annotation.SubResource;
import org.openmrs.module.webservices.rest.web.representation.RefRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;

@SubResource(parent = ItemStockResource.class, path="detail", supportedClass = ItemStockDetail.class, supportedOpenmrsVersions={"1.9"})
public class ItemStockDetailResource extends ItemStockDetailBaseResource<ItemStockDetail> {
	@Override
	public DelegatingResourceDescription getRepresentationDescription(Representation rep) {
		DelegatingResourceDescription description =  super.getRepresentationDescription(rep);
		if (!(rep instanceof RefRepresentation)) {
			description.addProperty("stockroom", Representation.DEFAULT);
		}

		return description;
	}

	@Override
	public ItemStockDetail newDelegate() {
		return new ItemStockDetail();
	}

	@Override
	public Class<? extends IObjectDataService<ItemStockDetail>> getServiceClass() {
		return null;
	}
}

