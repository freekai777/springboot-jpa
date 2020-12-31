package com.example.springbootjpa.test;

import org.junit.platform.commons.util.StringUtils;

import java.util.*;

/**
 * 前缀树
 */
public class TNode {

    /**
     * 是否是单词的结束
     */
    private Boolean isWorldEnd;

    /**
     * 是否是根节点
     */
    private Boolean isRoot;

    /**
     * 子节点
     */
    private Map<String,TNode> subNodes = new HashMap<>();

    /**
     * 当前node的值
     */
    private String val;


    public void addNode(TNode parentNode,TNode tNode){
        parentNode.getSubNodes().put(tNode.getVal(), tNode);
    }
    /**
     * 构建前缀树
     */
    private void buildTree(TNode tNode, String word){
        if(Objects.equals("",word)){
            return;
        }
        if(tNode == null){
            tNode = new TNode(true);
        }

        for (int i = 0; i < word.length(); i++) {
            final String substring = word.substring(i, i + 1);
            TNode tempNode = tNode.getSubNodes().get(substring);
            if(tempNode == null){
                tempNode = new TNode();
                tempNode.setVal(substring);
                tNode.addNode(tNode,tempNode);
            }
            tNode = tempNode;

            if(i==word.length()-1){
                tempNode.setWorldEnd(true);
            }
        }
    }

    private String searchInTNode(TNode tNode, String word){
        TNode rootNode = tNode;

        int count = 0;
        int breakIndex = 0;
        for (int i = 0; i < word.length(); i++) {
            String s = word.substring(i,i+1);
            TNode tNode1 = tNode.getSubNodes().get(s);
            // 下一个字符是空格，当作分词处理
            String nextStr = i==word.length()-1?" ":word.substring(i+1, i+2);
            if(tNode1!=null){
                if(isSymbol(nextStr)){
                    if(tNode1.getWorldEnd()!=null && tNode1.getWorldEnd() == true){
                        count++;
                    }
                    // 回溯
                    tNode = rootNode;
                }else{
                    // 节点下钻
                    tNode = tNode1;
                }

            }

        }
        return "匹配到" + count;
    }

    private boolean isSymbol(String s){
        return Objects.equals( " ", s);
    }

    public static void main(String[] args) {
        final List<String> list = Arrays.asList("are", "arm", "army", "amy","array", "bird", "bed", "beg", "bad");
        TNode t = new TNode(true);
        for (String s : list) {
            t.buildTree(t,s);
        }

//        System.out.println(t);
        System.out.println("==================");
        final String arre = t.searchInTNode(t, "army ");
        System.out.println("搜索结果：" +  arre);
    }

    public Boolean getWorldEnd() {
        return isWorldEnd;
    }

    public void setWorldEnd(Boolean worldEnd) {
        isWorldEnd = worldEnd;
    }

    public Map<String, TNode> getSubNodes() {
        return subNodes;
    }

    public void setSubNodes(Map<String, TNode> subNodes) {
        this.subNodes = subNodes;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public TNode() {
    }

    public TNode(Boolean isRoot) {
        this.isRoot = isRoot;
    }

    @Override
    public String toString() {
        return "TNode{" +
                "isWorldEnd=" + isWorldEnd +
                ", isRoot=" + isRoot +
                ", subNodes=" + subNodes +
                ", val='" + val + '\'' +
                '}';
    }
}
