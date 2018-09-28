package com.kentrasoft.cms.service.impl;

import com.kentrasoft.cms.dao.PayRecordMapper;
import com.kentrasoft.cms.entity.PayRecord;
import com.kentrasoft.cms.entity.PayRecordExample;
import com.kentrasoft.cms.entity.PayRecordExample.Criteria;
import com.kentrasoft.cms.entity.dto.DrivingPayRecord;
import com.kentrasoft.cms.service.PayRecordService;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.plugin.PageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

/**
 * 描述：缴费记录接口实现类
 * @author jiaming
 *
 */
@Service
public class PayRecordServiceImpl implements PayRecordService {
	
	@Autowired
	private PayRecordMapper  payRecordMapper;
	
	/**
	 * 分页查询缴费费记录
	 */
	@Override
	public PageForm<PayRecord> getPageList(PageForm<PayRecord> page , String licenseNum, String payStatus, String isPay) {
		PayRecordExample payRecordExample = new PayRecordExample();
		Criteria crit = payRecordExample.or();
		if (licenseNum != null && licenseNum != "") {
            crit.andLicenseNumLike("%"+licenseNum+"%");
        }
		if (payStatus != null && payStatus != "") {
            crit.andPayStatusLike("%"+payStatus+"%");
        }
		if (isPay != null && isPay != "") {
            crit.andIsPayLike("%"+isPay+"%");
        }
		payRecordExample.or(crit);
		//查询所有的数据数量
		long PayRecordCount = payRecordMapper.countByExample(payRecordExample);
		//分页查询所有的数据
		payRecordExample.setLimitStart((page.getPage() - 1) * page.getLimit());
		payRecordExample.setLimitEnd(page.getLimit());
		List<PayRecord> dList = payRecordMapper.selectByExample(payRecordExample);
		DecimalFormat    df   = new DecimalFormat("######0.00");
		for (PayRecord payRecord : dList) {
			payRecord.setPayCountstr(df.format(payRecord.getPayCount()));
			payRecord.setReceivablesstr(df.format(payRecord.getReceivables()));
			payRecord.setExpensesPaidstr(df.format(payRecord.getExpensesPaid()));
		}
		//回写内容
		page.setCount((int) PayRecordCount);
		page.setData(dList);
		return page;
    }
	
	/**
	 * 新增缴费记录
	 */
	@Override
	public void add(PayRecord record) {
		payRecordMapper.insert(record);		
	}
	
	/**
	 * 删除
	 */
	@Override
	public String delete(String ids) {
        try {
        	payRecordMapper.deleteByPKs(ids);
            return "200";
        } catch (Exception e) {
            return e.getMessage();
        }
	}

	/**
	 * 修改
	 */
	@Override
	public void edit(PayRecord record) {
		payRecordMapper.updateByPrimaryKeySelective(record);		
	}

	/**
	 * 导出
	 */
	@Override
	public List<PayRecord> exportPayRecord(String licenseNumParam,String PayStatusParam,String IsPayParam) {
		
		if(licenseNumParam != null && licenseNumParam != "" || PayStatusParam != null && PayStatusParam != "" || IsPayParam != null && IsPayParam != ""){
			List<PayRecord> list = payRecordMapper.queryPayRecordListBykey(licenseNumParam,PayStatusParam,IsPayParam);
			DecimalFormat    df   = new DecimalFormat("######0.00");
			for (PayRecord payRecord : list) {
				payRecord.setPayCountstr(df.format(payRecord.getPayCount()));
			}
			return list;
		}else {
			List<PayRecord> list = payRecordMapper.selectPayRecord();
			DecimalFormat    df   = new DecimalFormat("######0.00");
			for (PayRecord payRecord : list) {
				payRecord.setPayCountstr(df.format(payRecord.getPayCount()));
			}
			return list;
		}
	}

	/**
	 * 描述：查询用户行车缴费记录
	 * @param queryData
	 * @return
	 */
	@Override
	public BaseResult findDrivingPayment(Map<String,Object> queryData) {
		List<DrivingPayRecord> drivingPayRecord = payRecordMapper.findDrivingPayment(queryData);
		return BaseResult.success("查询成功",drivingPayRecord);
	}
}
