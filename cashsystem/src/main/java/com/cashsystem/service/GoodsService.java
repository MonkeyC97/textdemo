package com.cashsystem.service;

import com.cashsystem.dao.GoodsDao;
import com.cashsystem.entity.Goods;

import java.util.List;


public class GoodsService {
    public GoodsDao goodsDao;
    public GoodsService(){
        this.goodsDao = new GoodsDao();
    }
    public List<Goods> quarryAllGoods(){
        return this.goodsDao.quarryAllGoods();
    }
    //上架商品
    public boolean putAwayGoods(Goods goods){
        return this.goodsDao.putAwayGoods(goods);
    }
    //更新商品
    //根据goodsId拿到对应的货物
    public Goods getGoods(int goodsId){
        return this.goodsDao.getGoods(goodsId);
    }
    public boolean modifyGoods(Goods goods){
        return this.goodsDao.modifyGoods(goods);
    }
    //下架商品
    public boolean soldOutGoods(int id){
        return this.goodsDao.soldOutGoods(id);
    }

}
