/*
 * The contents of this file are subject to the OpenMRS Public License
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See
 * the License for the specific language governing rights and
 * limitations under the License.
 *
 * Copyright (C) OpenHMIS.  All Rights Reserved.
 */
package org.openmrs.module.webservices.rest.web.controller;

import org.openmrs.module.openhmis.commons.api.entity.model.IAttributeType;
import org.openmrs.module.openhmis.inventory.api.IItemAttributeTypeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = ItemAttributeFragmentController.REQUEST_MAPPING_PATH)
public class ItemAttributeFragmentController extends AttributeFragmentControllerBase {
	public static final String REQUEST_MAPPING_PATH = AttributeFragmentControllerBase.REQUEST_MAPPING_PATH_BASE + "Item";

	private IItemAttributeTypeDataService service;

	@Autowired
	public ItemAttributeFragmentController(IItemAttributeTypeDataService service) {
		this.service = service;
	}

	@Override
	protected List<? extends IAttributeType> getAttributeTypes(HttpServletRequest request) {
		return service.getAll();
	}
}
