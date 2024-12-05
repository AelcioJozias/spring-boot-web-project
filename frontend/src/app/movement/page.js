'use client';

import React, {useState} from 'react';
import {Button, Form, Input, message, Select, Table} from 'antd';

const {Option} = Select;

const MovimentacaoTela = () => {
    const [movimentacoes, setMovimentacoes] = useState([]);
    const [form] = Form.useForm();

    const handleSubmit = (values) => {
        const {pessoa, conta, acao, valor} = values;
        const newMovimentacao = {
            data: new Date().toLocaleDateString(),
            valor: acao === 'Depositar' ? valor : -valor,
        };

        setMovimentacoes([...movimentacoes, newMovimentacao]);
        form.resetFields();
        message.success('Movimentação registrada com sucesso!');
    };

    const columns = [
        {
            title: 'Data',
            dataIndex: 'data',
            key: 'data',
        },
        {
            title: 'Valor (R$)',
            dataIndex: 'valor',
            key: 'valor',
            render: (text) => <span style={{color: text < 0 ? 'red' : 'green'}}>{text}</span>,
        },
    ];

    return (
        <div style={{maxWidth: 600, margin: '0 auto'}}>
            <h2>Cadastro de Movimentações</h2>
            <Form form={form} onFinish={handleSubmit} layout="vertical">
                <Form.Item label="Pessoa" name="pessoa"
                           rules={[{required: true, message: 'Por favor, selecione a pessoa'}]}>
                    <Select placeholder="Selecione a pessoa">
                        <Option value="Fulano da Silva">Fulano da Silva - 000.111.222-33</Option>
                    </Select>
                </Form.Item>

                <Form.Item label="Conta" name="conta"
                           rules={[{required: true, message: 'Por favor, selecione a conta'}]}>
                    <Select placeholder="Selecione a conta">
                        <Option value="123456789">123456789 - Saldo: R$ 500,00</Option>
                    </Select>
                </Form.Item>

                <Form.Item label="Ação" name="acao" rules={[{required: true, message: 'Por favor, selecione a ação'}]}>
                    <Select placeholder="Selecione a ação">
                        <Option value="Depositar">Depositar</Option>
                        <Option value="Retirar">Retirar</Option>
                    </Select>
                </Form.Item>

                <Form.Item label="Valor" name="valor" rules={[{required: true, message: 'Por favor, informe o valor'}]}>
                    <Input type="number" placeholder="Valor"/>
                </Form.Item>

                <Form.Item>
                    <Button type="primary" htmlType="submit">Salvar</Button>
                </Form.Item>
            </Form>

            <h3>Extrato</h3>
            <Table columns={columns} dataSource={movimentacoes} rowKey="data" pagination={false}/>
        </div>
    );
};

export default MovimentacaoTela;

