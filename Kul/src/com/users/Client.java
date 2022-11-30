package com.users;
public class Client
{
  public String name;
  public  int money;
  public void buy(int cost)
  {
    money=money-cost;
  }
}