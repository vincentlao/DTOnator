/*
 * Copyright (C) 2015 Vinaya Prasad N
 *
 *         This program is free software: you can redistribute it and/or modify
 *         it under the terms of the GNU General Public License as published by
 *         the Free Software Foundation, either version 3 of the License, or
 *         (at your option) any later version.
 *
 *         This program is distributed in the hope that it will be useful,
 *         but WITHOUT ANY WARRANTY; without even the implied warranty of
 *         MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *         GNU General Public License for more details.
 *
 *         You should have received a copy of the GNU General Public License
 *         along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.nvinayshetty.DTOnator.FieldRepresentors;

import java.util.HashMap;

/**
 * Created by vinay on 9/5/15.
 */
public class FieldRepresenterFactory {
    HashMap<String, FieldRepresentor> dataTypeToDataObjectRepresentor = new HashMap();
    BooleanFieldRepresentor booleanFieldRepresentor = new BooleanFieldRepresentor();
    IntegerFieldRepresentor integerFieldRepresentor = new IntegerFieldRepresentor();
    DoubleFieldRepresentor doubleFieldRepresentor = new DoubleFieldRepresentor();
    JsonObjectRepresentor jsonObjectRepresentor = new JsonObjectRepresentor();
    JsonArrayRepresentor jsonArrayRepresentor = new JsonArrayRepresentor();
    StringFieldRepresentor stringFieldRepresentor = new StringFieldRepresentor();

    private void init() {
        dataTypeToDataObjectRepresentor.put("Boolean", booleanFieldRepresentor);
        dataTypeToDataObjectRepresentor.put("Integer", integerFieldRepresentor);
        dataTypeToDataObjectRepresentor.put("Double", doubleFieldRepresentor);
        dataTypeToDataObjectRepresentor.put("JSONObject", jsonObjectRepresentor);
        dataTypeToDataObjectRepresentor.put("JSONArray", jsonArrayRepresentor);
    }

    public FieldRepresentor convert(String type) {
        init();
        if (dataTypeToDataObjectRepresentor.containsKey(type)) {
            return dataTypeToDataObjectRepresentor.get(type);
        } else {
            return new StringFieldRepresentor();
        }
    }

}

