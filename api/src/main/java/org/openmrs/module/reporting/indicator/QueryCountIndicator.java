/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.reporting.indicator;

import org.openmrs.module.reporting.common.Localized;
import org.openmrs.module.reporting.definition.configuration.ConfigurationProperty;
import org.openmrs.module.reporting.evaluation.parameter.Mapped;
import org.openmrs.module.reporting.query.Query;

/**
 * Query-based indicator
 */
@Localized("reporting.QueryCountIndicator")
public class QueryCountIndicator extends BaseIndicator {

    //***** PROPERTIES *****

    @ConfigurationProperty
    private Mapped<? extends Query> query;

    //***** CONSTRUCTORS *****

    /**
     * Default Constructor
     */
    public QueryCountIndicator() { }
    
    //***** Property Access *****


	public Mapped<? extends Query> getQuery() {
		return query;
	}

	public void setQuery(Mapped<? extends Query> query) {
		this.query = query;
	}
}