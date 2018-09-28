package com.kentrasoft.cms.service.impl;

import com.kentrasoft.cms.dao.TollStationMapper;
import com.kentrasoft.cms.entity.TollStation;
import com.kentrasoft.cms.entity.TollStationExample;
import com.kentrasoft.cms.entity.TollStationExample.Criteria;
import com.kentrasoft.cms.service.TollStationService;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.plugin.PageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TollStationServiceImpl implements TollStationService {

	@Autowired
	private TollStationMapper	tollStationMapper;
	
	@Override
	public PageForm<TollStation> getPageList(PageForm<TollStation> page, String tollStationName, String tollStationCode) {
		TollStationExample tollStationExample = new TollStationExample();
		
		Criteria crit = tollStationExample.or();
        if (tollStationName != null && tollStationName != "") {
            crit.andTollStationNameLike("%"+tollStationName+"%");
        }
        if (tollStationCode != null && tollStationCode != "") {
            crit.andTollStationCodeLike("%"+tollStationCode+"%");
        }
        tollStationExample.or(crit);

        //查询所有的数据数量
        long tollStationCount = tollStationMapper.countByExample(tollStationExample);

        //分页查询所有的数据
        tollStationExample.setLimitStart((page.getPage() - 1) * page.getLimit());
        tollStationExample.setLimitEnd(page.getLimit());

        
        List<TollStation> tollStations = tollStationMapper.selectByExample(tollStationExample);

        //回写内容
        page.setCount((int) tollStationCount);
        page.setData(tollStations);

        return page;
	}

	@Override
	public BaseResult add(TollStation tollStation) {
		tollStation.setStatus("01");
        tollStationMapper.insert(tollStation);
        return BaseResult.success("收费站信息录入成功！");
	}

	@Override
	public BaseResult delete(String ids) {
		tollStationMapper.deleteByPrimaryKey(ids);
		return BaseResult.success("收费站信息删除成功！");
	}

	@Override
	public BaseResult edit(TollStation tollStation) {
		tollStationMapper.updateByPrimaryKeySelective(tollStation);
        return BaseResult.success("收费站信息修改成功！");
	}

	@Override
	public List<TollStation> exportBreakRecord(String tollStationName,String tollStationCode) {
		TollStationExample tollStationExample = new TollStationExample();
		Criteria crit = tollStationExample.or();
        if (tollStationName != null && tollStationName != "") {
            crit.andTollStationNameLike("%"+tollStationName+"%");
        }
        if (tollStationCode != null && tollStationCode != "") {
            crit.andTollStationCodeLike("%"+tollStationCode+"%");
        }
        tollStationExample.or(crit);
		List<TollStation> tollStationList =tollStationMapper.selectByExample(tollStationExample);
		return tollStationList;
	}

}
