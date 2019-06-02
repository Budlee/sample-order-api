package com.budlee.orderapi.model.error.microsoft;

import lombok.Value;

import java.util.List;

/**
 * https://github.com/Microsoft/api-guidelines/blob/master/Guidelines.md#51-errors
 * {
 *   "error": {
 *     "code": "BadArgument",
 *     "message": "Multiple errors in ContactInfo data",
 *     "target": "ContactInfo",
 *     "details": [
 *       {
 *         "code": "NullValue",
 *         "target": "PhoneNumber",
 *         "message": "Phone number must not be null"
 *       },
 *       {
 *         "code": "NullValue",
 *         "target": "LastName",
 *         "message": "Last name must not be null"
 *       },
 *       {
 *         "code": "MalformedValue",
 *         "target": "Address",
 *         "message": "Address is not valid"
 *       }
 *     ]
 *   }
 * }
 */
@Value
public class ClientError {
    /**
     * One of a server-defined set of error codes.
     */
    private String code;

    /**
     * A human-readable representation of the error.
     */
    private String message;

    /**
     * The target of the error.
     */
    private String target;

    /**
     * An array of details about specific errors that led to this reported error.
     */
    private List<ClientError> details;

    /**
     * An object containing more specific information than the current object about the error.
     */
    private InnerError innerError;
}
