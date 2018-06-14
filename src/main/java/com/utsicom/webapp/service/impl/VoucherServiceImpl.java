package com.utsicom.webapp.service.impl; 

import com.utsicom.webapp.model.Voucher;
import com.utsicom.webapp.service.VoucherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VoucherServiceImpl extends GenericServiceImpl<Voucher> implements VoucherService{ }
