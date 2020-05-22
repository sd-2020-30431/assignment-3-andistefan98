package com.server3.server3.services.handlers;

import com.server3.server3.services.queries.IRequest;
import com.server3.server3.services.responses.IResponse;

public interface IHandler<Request extends IRequest, Response extends IResponse> {

    Response handle(Request q);
}
