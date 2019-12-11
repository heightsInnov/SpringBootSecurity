package com.concretepage.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.UserInfo;
import com.concretepage.entity.enabler;

@Repository
@Transactional
public class UserInfoDAO {

	@Autowired
	IUserInfoDAO iuserinfodao;

	enabler[] en = enabler.values();
	public UserInfo getUserInfo(String userName) {
		UserInfo activeUserInfo = new UserInfo();
		List<?> users = iuserinfodao.findAll(new Specification<UserInfo>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<UserInfo> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				// TODO Auto-generated method stub
				List<Predicate> predicates = new ArrayList<>();
				if (userName != null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("enabled"), en[0])));
				}

				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		});
		if (!users.isEmpty()) {
			activeUserInfo = (UserInfo) users.get(0);
		}
		return activeUserInfo;
	}
}
